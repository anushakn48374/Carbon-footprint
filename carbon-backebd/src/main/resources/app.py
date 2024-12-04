from flask import Flask, request, jsonify
from PIL import Image
import pytesseract
import re
from anthropic import Anthropic
import io

# Initialize Flask app
app = Flask(__name__)

# Replace with your Anthropic API key
api_key = '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'
anthropic = Anthropic(api_key=api_key)

# Function to extract text from the image using PyTesseract
def extract_text(image):
    text = pytesseract.image_to_string(image)
    return text

# Function to analyze the extracted text and extract date, time, and destination
def analyze_text(text):
    date_pattern1 = r'\b(\d{2}[/,-]\d{2}[/,-]\d{4})\b'
    date_pattern2 = r'\b(\d{2}[/,-]\d{2}[/,-]\d{2})\b'

    time_pattern = r'\b(\d{2}[:]\d{2}[:]\d{2})\b'
    destination_pattern = r"Destination:\s*(.*)"

    date_match = re.search(date_pattern1, text)
    if date_match is None:
        date_match = re.search(date_pattern2, text)
    print(date_match)
    time_match = re.search(time_pattern, text)
    print(time_match)
    destination_match = re.search(destination_pattern, text)

    date = date_match.group(0) if date_match else None
    print(date)
    time = time_match.group(0) if time_match else None
    print(time)
    destination = destination_match.group(1) if destination_match else None

    return date, time, destination

# Function to call the Anthropic API for further analysis (if needed)
def call_anthropic_api(text):
    response = anthropic.complete(
        prompt="Analyze the following text to extract date, time, and destination:\n" + text,
        model="claude-3-5-sonnet-20240620",
        max_tokens=50
    )
    return response["completion"]

# API endpoint to extract date, time, and destination from the image
@app.route('/extract-info', methods=['POST'])
def extract_info():
    if 'image' not in request.files:
        return jsonify({'error': 'No image file provided'}), 400

    file = request.files['image']
    if file.filename == '':
        return jsonify({'error': 'No selected file'}), 400

    # Read the image in memory
    image = Image.open(io.BytesIO(file.read()))

    # Process the image to extract information
    date, time, destination = parse_bus_ticket(image)

    if date or time or destination:
        return jsonify({
            'date': date
        })
    else:
        return jsonify({'error': 'No relevant information found in the image'}), 404

def parse_bus_ticket(image):
    text = extract_text(image)
    date, time, destination = analyze_text(text)
    return date, time, destination

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000, debug=True)
