package org.brewmaster.authorization

class AuthorizingController {
    def beforeInterceptor = [action:this.&auth, except: 'login'];

    def auth() {
        if(!session.user) {
            redirect(controller:"Brewer", action:"login")
            return false
        }
    }
}
