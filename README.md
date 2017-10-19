# BusinessWorks Custom Compress Functions

## Overview

Provides TIBCO BusinessWorks with the ability to gzip/gunzip Strings directly within the BusinessWorks mapper. Particularly useful if you want to store large strings - such as XML Payloads in a database or other store but want it compressed to save space.

## Prerequisites/Minimum Platform version

Works for TIBCO BusinessWorks 6.x. Built using BW 6.4.1 but should work with all previous and upcoming BW 6.x versions.

You will need to be using JRE 1.8 as it utilises java.util.zip.GZIPInputStream and java.util.zip.GZIPOutputStream

## Installation Steps

Full source is incuded. Use eGit within BusinessWorks to clone this repository into your Workspace.

Once cloned, right click on the project (compressFunctions), choose Export, choose Deployable Plugins and Fragments

Make sure you select Install into Host Repository. You will have to accept the unsigned installation and restart BusinessWorks

### Description 

Using the Compress Functions in the TIBCO BusinessWorks Mapper:
![logo]

[logo]: https://github.com/adam-p/markdown-here/raw/master/src/common/images/icon48.png "BW Mapper"
