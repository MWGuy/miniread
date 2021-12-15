# miniread

Fast and simple manga reader. Goal of this project - make simple and self-managed alternative for [grouple](https://grouple.co) network with the same functionality.

## Features

* Uses postgresql with cool extensions (such as hstore) for scalable and optimized data model
* Fulltext search support (can work with [elasticsearch](https://www.elastic.co), but for simplicity uses [apache lucene](https://lucene.apache.org/))
* Translation branches for different translation teams

## TODO

* Account with authority and restrictions systems
* Manga creating/editing/moderating
* Chapter uploading
* API (maybe?)
