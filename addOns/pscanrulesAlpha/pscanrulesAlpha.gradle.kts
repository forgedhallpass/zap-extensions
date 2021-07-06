description = "The alpha quality Passive Scanner rules"

zapAddOn {
    addOnName.set("Passive scanner rules (alpha)")
    zapVersion.set("2.10.0")

    manifest {
        author.set("ZAP Dev Team")
        extensions {
            register("org.zaproxy.zap.extension.pscanrulesAlpha.payloader.ExtensionPayloader") {
                classnames {
                    allowed.set(listOf("org.zaproxy.zap.extension.pscanrulesAlpha.payloader"))
                }
                dependencies {
                    addOns {
                        register("commonlib") {
                            version.set(">= 1.4.0 & < 2.0.0")
                        }
                    }
                    addOns {
                        register("custompayloads") {
                            version.set(">= 0.9.0 & < 1.0.0")
                        }
                    }
                }
            }
        }
        url.set("https://www.zaproxy.org/docs/desktop/addons/passive-scan-rules-alpha/")
    }
}

dependencies {
    compileOnly(parent!!.childProjects.get("commonlib")!!)
    compileOnly(parent!!.childProjects.get("custompayloads")!!)

    testImplementation(parent!!.childProjects.get("commonlib")!!)
    testImplementation(parent!!.childProjects.get("custompayloads")!!)
    testImplementation(project(":testutils"))
}
