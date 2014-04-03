description 'User can add reference witch is type book'

scenario "User can add reference to a book", {
	given 'User runs program'
	when 'all question fields have been filled'
	then 'reference will be added'
}
scenario "User can not add empty reference", {
	given 'User runs program'
	when 'user doesn't fill one of the fields and still presses enter'
	then 'program keeps asking for the same information'
}
