(ns leiningen.new.cljs-template
  (:use [leiningen.new.templates :only [renderer year name-to-path ->files
                                        sanitize-ns]]))

(def render (renderer "cljs-template"))

(defn cljs-template
  "ClojureScript template"
  [name]
  (let [data {:name        name
              :namespace   (sanitize-ns name)
              :nested-dirs (name-to-path name)
              :year        (year)}]
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             [".gitignore" (render ".gitignore" data)]
             ["phantom/repl.js" (render "phantom/repl.js" data)]
             ["phantom/unit-test.js" (render "phantom/unit-test.js" data)]
             ["src/cljs/repl.cljs" (render "src/cljs/repl.cljs" data)]
             ["resources/private/html/naked.html" (render "resources/private/html/naked.html" data)]
             ["resources/private/html/unit-test.html" (render "resources/private/html/unit-test.html" data)]
             ["src/cljs/repl.clj" (render "src/cljs/repl.cljs" data)]
             ["test/cljs/{{nested-dirs}}/test.cljs" (render "test/cljs/test.cljs" data)]
             ["test/cljs/{{nested-dirs}}/test/feature1.cljs" (render "test/cljs/test/feature1.cljs" data)]
             )))
