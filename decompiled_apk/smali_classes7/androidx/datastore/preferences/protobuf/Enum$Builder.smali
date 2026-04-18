.class public final Landroidx/datastore/preferences/protobuf/Enum$Builder;
.super Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;
.source "Enum.java"

# interfaces
.implements Landroidx/datastore/preferences/protobuf/EnumOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/datastore/preferences/protobuf/Enum;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder<",
        "Landroidx/datastore/preferences/protobuf/Enum;",
        "Landroidx/datastore/preferences/protobuf/Enum$Builder;",
        ">;",
        "Landroidx/datastore/preferences/protobuf/EnumOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 695
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Enum;->access$000()Landroidx/datastore/preferences/protobuf/Enum;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;-><init>(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    .line 696
    return-void
.end method

.method synthetic constructor <init>(Landroidx/datastore/preferences/protobuf/Enum$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/datastore/preferences/protobuf/Enum$1;

    .line 688
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public addAllEnumvalue(Ljava/lang/Iterable;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Landroidx/datastore/preferences/protobuf/EnumValue;",
            ">;)",
            "Landroidx/datastore/preferences/protobuf/Enum$Builder;"
        }
    .end annotation

    .line 887
    .local p1, "values":Ljava/lang/Iterable;, "Ljava/lang/Iterable<+Landroidx/datastore/preferences/protobuf/EnumValue;>;"
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 888
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$1000(Landroidx/datastore/preferences/protobuf/Enum;Ljava/lang/Iterable;)V

    .line 889
    return-object p0
.end method

.method public addAllOptions(Ljava/lang/Iterable;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable<",
            "+",
            "Landroidx/datastore/preferences/protobuf/Option;",
            ">;)",
            "Landroidx/datastore/preferences/protobuf/Enum$Builder;"
        }
    .end annotation

    .line 1035
    .local p1, "values":Ljava/lang/Iterable;, "Ljava/lang/Iterable<+Landroidx/datastore/preferences/protobuf/Option;>;"
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1036
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$1900(Landroidx/datastore/preferences/protobuf/Enum;Ljava/lang/Iterable;)V

    .line 1037
    return-object p0
.end method

.method public addEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 874
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 875
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->access$900(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)V

    .line 876
    return-object p0
.end method

.method public addEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 848
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 849
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->access$700(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/EnumValue;)V

    .line 850
    return-object p0
.end method

.method public addEnumvalue(Landroidx/datastore/preferences/protobuf/EnumValue$Builder;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 861
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 862
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$800(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/EnumValue$Builder;)V

    .line 863
    return-object p0
.end method

.method public addEnumvalue(Landroidx/datastore/preferences/protobuf/EnumValue;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 835
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 836
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$600(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/EnumValue;)V

    .line 837
    return-object p0
.end method

.method public addOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 1022
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1023
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->access$1800(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/Option$Builder;)V

    .line 1024
    return-object p0
.end method

.method public addOptions(ILandroidx/datastore/preferences/protobuf/Option;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 996
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 997
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->access$1600(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/Option;)V

    .line 998
    return-object p0
.end method

.method public addOptions(Landroidx/datastore/preferences/protobuf/Option$Builder;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 1009
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1010
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$1700(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/Option$Builder;)V

    .line 1011
    return-object p0
.end method

.method public addOptions(Landroidx/datastore/preferences/protobuf/Option;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 983
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 984
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$1500(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/Option;)V

    .line 985
    return-object p0
.end method

.method public clearEnumvalue()Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1

    .line 899
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 900
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Enum;->access$1100(Landroidx/datastore/preferences/protobuf/Enum;)V

    .line 901
    return-object p0
.end method

.method public clearName()Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1

    .line 748
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 749
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Enum;->access$200(Landroidx/datastore/preferences/protobuf/Enum;)V

    .line 750
    return-object p0
.end method

.method public clearOptions()Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1

    .line 1047
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1048
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Enum;->access$2000(Landroidx/datastore/preferences/protobuf/Enum;)V

    .line 1049
    return-object p0
.end method

.method public clearSourceContext()Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1

    .line 1130
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1131
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Enum;->access$2500(Landroidx/datastore/preferences/protobuf/Enum;)V

    .line 1132
    return-object p0
.end method

.method public clearSyntax()Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1

    .line 1196
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1197
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Enum;->access$2800(Landroidx/datastore/preferences/protobuf/Enum;)V

    .line 1198
    return-object p0
.end method

.method public getEnumvalue(I)Landroidx/datastore/preferences/protobuf/EnumValue;
    .locals 1
    .param p1, "index"    # I

    .line 799
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->getEnumvalue(I)Landroidx/datastore/preferences/protobuf/EnumValue;

    move-result-object v0

    return-object v0
.end method

.method public getEnumvalueCount()I
    .locals 1

    .line 789
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getEnumvalueCount()I

    move-result v0

    return v0
.end method

.method public getEnumvalueList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/datastore/preferences/protobuf/EnumValue;",
            ">;"
        }
    .end annotation

    .line 777
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    .line 778
    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getEnumvalueList()Ljava/util/List;

    move-result-object v0

    .line 777
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .line 709
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getNameBytes()Landroidx/datastore/preferences/protobuf/ByteString;
    .locals 1

    .line 722
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getNameBytes()Landroidx/datastore/preferences/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getOptions(I)Landroidx/datastore/preferences/protobuf/Option;
    .locals 1
    .param p1, "index"    # I

    .line 947
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->getOptions(I)Landroidx/datastore/preferences/protobuf/Option;

    move-result-object v0

    return-object v0
.end method

.method public getOptionsCount()I
    .locals 1

    .line 937
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getOptionsCount()I

    move-result v0

    return v0
.end method

.method public getOptionsList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List<",
            "Landroidx/datastore/preferences/protobuf/Option;",
            ">;"
        }
    .end annotation

    .line 925
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    .line 926
    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getOptionsList()Ljava/util/List;

    move-result-object v0

    .line 925
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSourceContext()Landroidx/datastore/preferences/protobuf/SourceContext;
    .locals 1

    .line 1084
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getSourceContext()Landroidx/datastore/preferences/protobuf/SourceContext;

    move-result-object v0

    return-object v0
.end method

.method public getSyntax()Landroidx/datastore/preferences/protobuf/Syntax;
    .locals 1

    .line 1171
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getSyntax()Landroidx/datastore/preferences/protobuf/Syntax;

    move-result-object v0

    return-object v0
.end method

.method public getSyntaxValue()I
    .locals 1

    .line 1145
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->getSyntaxValue()I

    move-result v0

    return v0
.end method

.method public hasSourceContext()Z
    .locals 1

    .line 1073
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Enum;->hasSourceContext()Z

    move-result v0

    return v0
.end method

.method public mergeSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 1119
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1120
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$2400(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/SourceContext;)V

    .line 1121
    return-object p0
.end method

.method public removeEnumvalue(I)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I

    .line 911
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 912
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$1200(Landroidx/datastore/preferences/protobuf/Enum;I)V

    .line 913
    return-object p0
.end method

.method public removeOptions(I)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I

    .line 1059
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1060
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$2100(Landroidx/datastore/preferences/protobuf/Enum;I)V

    .line 1061
    return-object p0
.end method

.method public setEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/EnumValue$Builder;

    .line 823
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 824
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->access$500(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/EnumValue$Builder;)V

    .line 825
    return-object p0
.end method

.method public setEnumvalue(ILandroidx/datastore/preferences/protobuf/EnumValue;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/EnumValue;

    .line 810
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 811
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->access$400(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/EnumValue;)V

    .line 812
    return-object p0
.end method

.method public setName(Ljava/lang/String;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .line 735
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 736
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$100(Landroidx/datastore/preferences/protobuf/Enum;Ljava/lang/String;)V

    .line 737
    return-object p0
.end method

.method public setNameBytes(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 763
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 764
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$300(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/ByteString;)V

    .line 765
    return-object p0
.end method

.method public setOptions(ILandroidx/datastore/preferences/protobuf/Option$Builder;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Option$Builder;

    .line 971
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 972
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->access$1400(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/Option$Builder;)V

    .line 973
    return-object p0
.end method

.method public setOptions(ILandroidx/datastore/preferences/protobuf/Option;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "index"    # I
    .param p2, "value"    # Landroidx/datastore/preferences/protobuf/Option;

    .line 958
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 959
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Enum;->access$1300(Landroidx/datastore/preferences/protobuf/Enum;ILandroidx/datastore/preferences/protobuf/Option;)V

    .line 960
    return-object p0
.end method

.method public setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext$Builder;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/SourceContext$Builder;

    .line 1107
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1108
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$2300(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/SourceContext$Builder;)V

    .line 1109
    return-object p0
.end method

.method public setSourceContext(Landroidx/datastore/preferences/protobuf/SourceContext;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/SourceContext;

    .line 1094
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1095
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$2200(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/SourceContext;)V

    .line 1096
    return-object p0
.end method

.method public setSyntax(Landroidx/datastore/preferences/protobuf/Syntax;)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Syntax;

    .line 1183
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1184
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$2700(Landroidx/datastore/preferences/protobuf/Enum;Landroidx/datastore/preferences/protobuf/Syntax;)V

    .line 1185
    return-object p0
.end method

.method public setSyntaxValue(I)Landroidx/datastore/preferences/protobuf/Enum$Builder;
    .locals 1
    .param p1, "value"    # I

    .line 1157
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Enum$Builder;->copyOnWrite()V

    .line 1158
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Enum$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Enum;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Enum;->access$2600(Landroidx/datastore/preferences/protobuf/Enum;I)V

    .line 1159
    return-object p0
.end method
