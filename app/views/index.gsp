<%@ page import="grace.demos.ButtonComponent; grace.demos.CardComponent" %>

<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grace</title>
</head>
<body>

<div id="content" role="main">
    <div class="container">
        <section class="row">
            <h1>Grace View Components</h1>

            <p>
                <a href="https://github.com/grace-plugins/grace-view-components" target="_blank">Grace View Components</a> is a Grace plugin for creating reusable, testable and encapsulated view components.
            </p>

        </section>
        <div class="row p-3">
            <div class="col-3">
                ${new CardComponent(title: 'My First Component', content: 'This is the first Card').render()}
            </div>
            <div class="col-3">
                ${new CardComponent(title: 'My Second Component', content: 'This is the second Card').render()}
            </div>
            <div class="col-3">
                ${new CardComponent(title: 'My Third Component', content: 'This is the third Card').render()}
            </div>
            <div class="col-3">
                <vc:card title="My Fouth Component" content="This is the fouth Card" />
            </div>
        </div>
        <div class="row p-3">
            <div class="col-4">
                ${new ButtonComponent(name: 'Primary Button', cssClasses: 'btn-primary').render()}
                ${new ButtonComponent(name: 'Success Button', cssClasses: 'btn-success').render()}
            </div>
            <div class="col-4">
                ${new ButtonComponent(name: 'Large Success Button', cssClasses: 'btn-success', size: 'lg').render()}
                ${new ButtonComponent(name: 'Small Success Button', cssClasses: 'btn-success', size: 'sm').render()}
            </div>
            <div class="col-2">
                ${new ButtonComponent(name: 'Disabled Button', cssClasses: 'btn-success', size: 'sm', state: 'disabled').render()}
            </div>
            <div class="col-2">
                <vc:button type="button" name="Demo Button" cssClasses="btn-warning" color="#f00" />
            </div>
        </div>
        <div class="row p-3">
            <div class="col-4">
                <vc:icon name="alarm" />
            </div>
            <div class="col-4">
                <vc:icon name="apple" />
            </div>
            <div class="col-2">
                <vc:icon name="bag" />
            </div>
            <div class="col-2">
                <vc:icon name="bank" />
                <vc:icon name="box" />
            </div>
        </div>
    </div>
</div>

</body>
</html>
