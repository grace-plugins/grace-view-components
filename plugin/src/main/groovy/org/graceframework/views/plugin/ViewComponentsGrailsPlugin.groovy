package org.graceframework.views.plugin

import grails.plugins.*

import org.graceframework.views.components.taglib.ComponentTagLib

class ViewComponentsGrailsPlugin extends Plugin {

    def version = '0.1.0-SNAPSHOT'
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2022.0.0 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]
    def dependsOn = [markupView: '1.0.0 > *']

    def watchedResources = ["file:./app/components/**/*Component.groovy",
                            "file:./plugins/*/app/components/**/*Component.groovy"]
    def providedArtefacts = [
            ComponentTagLib
    ]

    // TODO Fill in these fields
    def title = "Grace View Components" // Headline display name of the plugin
    def author = "Michael Yan"
    def authorEmail = "rain@rainboyan.com"
    def description = '''\
A Grace plugin for creating reusable, testable and encapsulated view components.
'''
    def profiles = ['web']

    // URL to the plugin's documentation
    def documentation = "https://github.com/grace-plugins/grace-view-components"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Any additional developers beyond the author specified above.
    def developers = [ [id: "rainboyan", name: "Michael Yan", email: "rain@rainboyan.com" ]]

    // Location of the plugin's issue tracker.
    def issueManagement = [ system: "GitHub", url: "https://github.com/grace-plugins/grace-view-components/issues" ]

    // Online location of the plugin's browseable source code.
    def scm = [ url: "https://github.com/grace-plugins/grace-view-components" ]

}
