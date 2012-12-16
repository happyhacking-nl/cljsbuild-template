(ns leiningen.new.cljsbuild-template
  (:use [leiningen.new.templates :only [renderer year name-to-path ->files
                                        sanitize-ns]]))

(def render (renderer "cljsbuild-template"))

(defn cljsbuild-template
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
             ["phantom/repl.js" (render "phantom_repl.js" data)]
             ["phantom/unit-test.js" (render "phantom_unit-test.js" data)]
             ["src/cljs/repl.cljs" (render "src_cljs_repl.cljs" data)]
             ["resources/private/html/naked.html" (render "resources_private_html_naked.html" data)]
             ["resources/private/html/unit-test.html" (render "resources_private_html_unit-test.html" data)]
             ["test/cljs/{{nested-dirs}}/test.cljs" (render "test_cljs_test.cljs" data)]
             ["test/cljs/{{nested-dirs}}/test/feature1.cljs" (render "test_cljs_test_feature1.cljs" data)]
             )))
