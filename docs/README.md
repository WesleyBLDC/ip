# User Guide

Willy is a **desktop app for managing your tasks via a Command Line Interface** (CLI) 
while still having the benefits of a Graphical User Interface (GUI).

## How to use

Type the commands in the chatbox and press `Send` or press the `Enter` key to execute it. Some example commands you can try:
- `list`: List all tasks.
- `todo groceries`: Adds a todo task with `groceries` as its description to the task list.
- `mark 1`: Marks the 1st task as done.
- `delete 1`: Deletes the 1st task.
- `bye`: Exits the app.


Refer to the [Features](##Features) below for details of each command.
<br />
<br />
## Features
<br />
<br />
### Listing all tasks: list
Shows a list of all tasks in your list.<br />
Format: `list`
<br />
<br />

### Adding a todo: `todo`
Adds a todo task to the task list.<br />
Format: `todo [task]`<br /><br />
Examples:
- `todo math homwework`
- `todo do assignments`
<br />
<br />


### Adding a deadline: `deadline`
Adds a deadline type to the task list.<br />
Format: `deadline [task] /by [YYYY-MM-DD]`<br /><br />
Examples:
- `deadline come home /by 2019-10-15`
- `deadline project work /by 2019-10-30`
<br />
<br />


### Adding an event: `event`
Adds an event to the task list.<br />
Format: `event [task] /from [YYYY-MM-DD] /to [YYYY-MM-DD]`<br /><br />
Examples:
- `event date night /from 2018-03-10 /to 2018-03-11`
- `event house event /from 2018-05-23 /to 2018-05-26`
<br />
<br />

### Marking a task: `mark`
Marks an existing task as done.<br /> 
Format: `mark [task number]`<br />
- Marks the task as done
- The `task number` refers to the index number shown in the displayed task list.
- The index must be a positive integer starting from 1.<br /><br /> 
Examples:
- `mark 1`
- `mark 3`
<br />
<br />

### Un-marking a task: `unmark`
Un-marks an existing task as not done.<br />
Format: `unmark [task number]`<br />
- Un-marks the task
- The `task number` refers to the index number shown in the displayed task list.
- The index must be a positive integer starting from 1.<br /><br />
Examples:
- `unmark 1`
- `unmark 3`
<br />
<br />

### Locating a task: `find`
Find tasks whose description or date contain the given keyword.<br />
Format: `find [keyword]`<br />
- The search is case-sensitive.<br /><br />
Examples:
- `find assignment` returns `[T][X]todo math assignment`
- `find 10 Mar` returns `[D][ ]deadline return screwdriver (by: 10 Mar 2019)`
<br />
<br />


### Deleting a task: `delete`
Deletes the task at the specified task number from the task list.<br />
Format: `delete [task number]`<br />
- Deletes the task
- The `task number` refers to the index number shown in the displayed task list.
- The index must be a positive integer starting from 1.<br /><br />
Examples:
- `delete 1`
- `delete 2`
<br />
<br />

### Deleting a task: `help`
Displays the help screen with all the commands available<br />
Format: `help`<br />
- Displays all the commands
Examples:
- `help`
<br />
<br />

### Exiting the program: `bye`
Exits the program.<br />
Format: `bye`
<br />
<br />


### Saving the data
Willy data are saved in the hard disk automatically after any command that changes the data. 
You do not need to save the data manually.
<br />
<br />
***
