(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/clojurescript "0.0-1450"]]
  :source-paths ["src/cljs"]
  :plugins [[lein-cljsbuild "0.2.7"]]
  :hooks [leiningen.cljsbuild]
  :min-lein-version "2.0.0"
  :cljsbuild {:repl-listen-port     9000
              :repl-launch-commands {"phantom"       ["phantomjs"
                                                      "phantom/repl.js"
                                                      :stdout ".repl-phantom-out"
                                                      :stderr ".repl-phantom-err"]
                                     "phantom-naked" ["phantomjs"
                                                      "phantom/repl.js"
                                                      "resources/private/html/naked.html"
                                                      :stdout ".repl-phantom-naked-out"
                                                      :stderr ".repl-phantom-naked-err"]}
              :test-commands        {"unit" ["phantomjs"
                                             "phantom/unit-test.js"
                                             "resources/private/html/unit-test.html"]}
              :builds               {:dev  {:source-path "src/cljs"
                                            :compiler    {:output-to     "resources/public/js/main-debug.js"
                                                          :optimizations :simple
                                                          :pretty-print  true}}
                                     :prod {:source-path "src/cljs"
                                            :compiler    {:output-to     "resources/public/js/main.js"
                                                          :optimizations :advanced
                                                          :pretty-print  false}}
                                     :test {:source-path "test/cljs"
                                            :compiler    {:output-to     "resources/private/js/unit-test.js"
                                                          :optimizations :whitespace
                                                          :pretty-print  true}}}})
