##Graphql
* http://localhost:8080/graphiql?path=/graphql
```graphql
query MyQuery {
  authorById(id: 1) {
    id
    name
  }
# ------------------
  authors {
    id
    name
    books {
      # id
      title
    }
  }
}
# mutation {
#   addAuthor(name: "Shiva") {
#     name
#   }
# }
# -------------------------
# mutation MyAddBook{
#   addBook(book:  {
#      title: "Learn Graphql", author: 1
#   }) {
#     id
#   }
# }
# -------------------------


```
