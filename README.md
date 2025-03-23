# Covid-19 Data Parser for Philadelphia Department of Public Health

## Project Overview

The core project is designed to parse and analyze Covid-19 datasets from the Philadelphia Department of Public Health (PDPH). The goal is to track and compute insightful data, including vaccinations, deaths, per capita statistics based on ZIP code, and total market values. The program supports parsing datasets in both **JSON** and **CSV** file formats and is optimized for performance with a time complexity of **O(n)**.

The project design is based on the **Model-View-Controller (MVC)** architecture, which ensures modularity, scalability, and maintainability. For best practice, I incorporated conventional design patterns, such as **Singleton** for logging user activity and **Memoization** for efficient computation. The current code sample shared in this repository is a **CSV parsing helper function** written in **Java**. This function was a crucial part of the project, as it efficiently parses large CSV files while handling challenges like escaping double and single quotes in the data.

### Optimization:
Instead of using regular expressions, which would have introduced higher time complexity, I chose to parse each character of the string manually. This approach allowed me to maintain an **O(n)** time complexity while ensuring that the dataset was processed in an efficient manner.

## Why This Matters

Parsing large CSV files efficiently was a critical part of the project. Given the size of the Covid-19 datasets (often over 1GB), it was essential to process them quickly and without running into memory or performance bottlenecks. By choosing to manually handle string parsing rather than relying on regular expressions, I was able to make sure that the parsing process remained linear in time complexity (O(n)).

This focus on performance was not just about optimizing for speed but also about ensuring that the data could be processed without issues when working with real-world large datasets. The **CSV parsing helper function** exemplifies my approach to data processing, where efficiency and scalability are the primary concerns.

## How to Use

To use the CSV parser helper function, simply call the `Parse.parseLine()` static function, providing a string line as the parameter. The function returns a list of strings, where each index of the list denotes the respective column of the CSV file.

1. **Clone the repository**:
   ```bash
   git clone https://github.com/phvmous/CSVParser.git
2. **Run the code**:
   ```java
   String sampleCSVLine = "96022760,2021-07-05 09:29:19,A,NWC OF 24TH & OXFORD ST,53912171,SR   ,VACANT LAND RESIDE < ACRE,1 ,Single Family,139,Y,,,94.0,188045.0,0.0,1,,16.0,A,,,B ,29,0,,2334 ,1,2334 W OXFORD ST,,,,PHILADELPHIA PA,,19121,263000.0,,,3,10,1,,,BONDS ISHAKEA,,291113044,E,,2021-12-08 00:00:00,012N110470,2021-08-06 00:00:00,263000.0,,,,PA  ,62120,ST  ,W,OXFORD,,0.0,74955.0,F,1542.0,1242.0,A,,,,,2019,,19121,RSA5,1001680150,-75.17420968317221,39.979125733577334"

   ArrayList<String> data = Parser.parseLine(sampleCSVLine);

Contributing
Feel free to fork this repository and submit issues or pull requests if you find any bugs or would like to suggest improvements. Contributions are welcome!
