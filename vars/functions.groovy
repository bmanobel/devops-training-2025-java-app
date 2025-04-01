

def getLastGitTag() {
    sh "git tag --sort version:refname | tail -1 > version.tmp"
    String tag = readFile 'version.tmp'
    echo "Tag, ${tag}." 
    return tag
}