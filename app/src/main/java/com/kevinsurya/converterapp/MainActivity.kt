package com.kevinsurya.converterapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun printFiles(filePath: String, numCopies: Int, outputDirectory: File) {
            val inputFile = File(filePath)

            try {
                if (!inputFile.exists()) {
                    throw FileNotFoundException("File not found: $filePath")
                }

                for (i in 1..numCopies) {
                    val outputFileName = "${inputFile.nameWithoutExtension}_copy$i.${inputFile.extension}"
                    val outputFile = File(outputDirectory, outputFileName)

                    inputFile.copyTo(outputFile)
                    val tvPricing = findViewById<TextView>(R.id.tvPricing)
                    println("Printed copy $i to: $tvPricing")
                }
            } catch (e: IOException) {
                println("Error printing files: ${e.message}")
            }

        }

        val btnAmbil = findViewById<Button>(R.id.btnAmbil)
        btnAmbil.setOnClickListener {
            fun main() {
                val inputFilePath = "C:\\pricing.txt"
                val numCopies = 1

                val outputDirectoryPath = "printed_files"
                val outputDirectory = File(outputDirectoryPath)
                if (!outputDirectory.exists()) {
                    outputDirectory.mkdirs()
                }
                printFiles(inputFilePath, numCopies, outputDirectory)
            }
        }



        }
}