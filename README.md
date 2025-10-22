# Text Editor (Java, Swing)

Minimalistic cross-platform **text editor** in Java/Swing.  
It can open and save files, search in text (including **regular expressions**) and does not block the interface during the search.

## Features

- Open and save via `JFileChooser` (one instance, reused)
- Search modes: *regular substring* and *regular expression*
- Cyclic navigation by matches (wrap-around)
- Selection of the found fragment and automatic scrolling to it
- The search is performed in the background thread (`SwingWorker`), the UI does not "hang"

## Preview

<img width="586" height="443" alt="image" src="https://github.com/user-attachments/assets/5b4e2bfe-0f87-4838-afde-dc64023e2b91" />
