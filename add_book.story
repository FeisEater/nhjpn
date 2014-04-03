description 'User can add reference witch is type book'

scenario "User can add reference to a book", {
	given 'User begins program'
	when 'all informations are entered correctly'
	then 'reference will be added'
}
scenario "User can not add empty reference", {
	given 'User begins program'
	when 'does not enter some information'
	then 'program keeps asking same information'
}
