#!/bin/bash

# Prompt the user for the Java files to compile
read -p "Enter the Java files to compile: " compile_files

# Prompt the user for the main class to run
read -p "Enter the main class to run: " main_class

# Compile the specified Java files
echo "Compiling: $compile_files"
javac -cp ../../../algs4.jar:. $compile_files

# Check if the compilation was successful
if [ $? -eq 0 ]; then
  echo "Compilation successful."
  
  # Run the specified main class
  echo "Running: $main_class"
  java -cp .:../../../algs4.jar $main_class
else
  echo "Compilation failed. Please check for errors."
fi
