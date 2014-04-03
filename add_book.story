description 'User can add reference witch is type book'

scenario "User can add reference to a book", {
	given 'User runs program'
	when 'all information is entered correctly'
	then 'reference will be added'
}
scenario "User can not add empty reference", {
	given 'User runs program'
	when 'user presses enter without writing anything'
	then 'program keeps asking for the same information'
}
