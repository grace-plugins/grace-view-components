model {
    String title
    String content
}
div(class: "card") {
    div(class: "card-header") {
        yield title
    }
    div(class: "card-body") {
        p(content)
    }
}
