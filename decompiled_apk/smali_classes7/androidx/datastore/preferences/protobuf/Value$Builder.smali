.class public final Landroidx/datastore/preferences/protobuf/Value$Builder;
.super Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;
.source "Value.java"

# interfaces
.implements Landroidx/datastore/preferences/protobuf/ValueOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/datastore/preferences/protobuf/Value;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder<",
        "Landroidx/datastore/preferences/protobuf/Value;",
        "Landroidx/datastore/preferences/protobuf/Value$Builder;",
        ">;",
        "Landroidx/datastore/preferences/protobuf/ValueOrBuilder;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 1

    .line 584
    invoke-static {}, Landroidx/datastore/preferences/protobuf/Value;->access$000()Landroidx/datastore/preferences/protobuf/Value;

    move-result-object v0

    invoke-direct {p0, v0}, Landroidx/datastore/preferences/protobuf/GeneratedMessageLite$Builder;-><init>(Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;)V

    .line 585
    return-void
.end method

.method synthetic constructor <init>(Landroidx/datastore/preferences/protobuf/Value$1;)V
    .locals 0
    .param p1, "x0"    # Landroidx/datastore/preferences/protobuf/Value$1;

    .line 577
    invoke-direct {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;-><init>()V

    return-void
.end method


# virtual methods
.method public clearBoolValue()Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1

    .line 810
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 811
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Value;->access$1100(Landroidx/datastore/preferences/protobuf/Value;)V

    .line 812
    return-object p0
.end method

.method public clearKind()Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1

    .line 594
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 595
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Value;->access$100(Landroidx/datastore/preferences/protobuf/Value;)V

    .line 596
    return-object p0
.end method

.method public clearListValue()Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1

    .line 954
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 955
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Value;->access$1900(Landroidx/datastore/preferences/protobuf/Value;)V

    .line 956
    return-object p0
.end method

.method public clearNullValue()Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1

    .line 661
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 662
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Value;->access$400(Landroidx/datastore/preferences/protobuf/Value;)V

    .line 663
    return-object p0
.end method

.method public clearNumberValue()Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1

    .line 701
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 702
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Value;->access$600(Landroidx/datastore/preferences/protobuf/Value;)V

    .line 703
    return-object p0
.end method

.method public clearStringValue()Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1

    .line 755
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 756
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Value;->access$800(Landroidx/datastore/preferences/protobuf/Value;)V

    .line 757
    return-object p0
.end method

.method public clearStructValue()Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1

    .line 882
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 883
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0}, Landroidx/datastore/preferences/protobuf/Value;->access$1500(Landroidx/datastore/preferences/protobuf/Value;)V

    .line 884
    return-object p0
.end method

.method public getBoolValue()Z
    .locals 1

    .line 785
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getBoolValue()Z

    move-result v0

    return v0
.end method

.method public getKindCase()Landroidx/datastore/preferences/protobuf/Value$KindCase;
    .locals 1

    .line 590
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getKindCase()Landroidx/datastore/preferences/protobuf/Value$KindCase;

    move-result-object v0

    return-object v0
.end method

.method public getListValue()Landroidx/datastore/preferences/protobuf/ListValue;
    .locals 1

    .line 907
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getListValue()Landroidx/datastore/preferences/protobuf/ListValue;

    move-result-object v0

    return-object v0
.end method

.method public getNullValue()Landroidx/datastore/preferences/protobuf/NullValue;
    .locals 1

    .line 636
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getNullValue()Landroidx/datastore/preferences/protobuf/NullValue;

    move-result-object v0

    return-object v0
.end method

.method public getNullValueValue()I
    .locals 1

    .line 610
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getNullValueValue()I

    move-result v0

    return v0
.end method

.method public getNumberValue()D
    .locals 2

    .line 676
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getNumberValue()D

    move-result-wide v0

    return-wide v0
.end method

.method public getStringValue()Ljava/lang/String;
    .locals 1

    .line 716
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getStringValue()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getStringValueBytes()Landroidx/datastore/preferences/protobuf/ByteString;
    .locals 1

    .line 729
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getStringValueBytes()Landroidx/datastore/preferences/protobuf/ByteString;

    move-result-object v0

    return-object v0
.end method

.method public getStructValue()Landroidx/datastore/preferences/protobuf/Struct;
    .locals 1

    .line 835
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->getStructValue()Landroidx/datastore/preferences/protobuf/Struct;

    move-result-object v0

    return-object v0
.end method

.method public hasListValue()Z
    .locals 1

    .line 896
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->hasListValue()Z

    move-result v0

    return v0
.end method

.method public hasStructValue()Z
    .locals 1

    .line 824
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-virtual {v0}, Landroidx/datastore/preferences/protobuf/Value;->hasStructValue()Z

    move-result v0

    return v0
.end method

.method public mergeListValue(Landroidx/datastore/preferences/protobuf/ListValue;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/ListValue;

    .line 942
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 943
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$1800(Landroidx/datastore/preferences/protobuf/Value;Landroidx/datastore/preferences/protobuf/ListValue;)V

    .line 944
    return-object p0
.end method

.method public mergeStructValue(Landroidx/datastore/preferences/protobuf/Struct;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Struct;

    .line 870
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 871
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$1400(Landroidx/datastore/preferences/protobuf/Value;Landroidx/datastore/preferences/protobuf/Struct;)V

    .line 872
    return-object p0
.end method

.method public setBoolValue(Z)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # Z

    .line 797
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 798
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$1000(Landroidx/datastore/preferences/protobuf/Value;Z)V

    .line 799
    return-object p0
.end method

.method public setListValue(Landroidx/datastore/preferences/protobuf/ListValue$Builder;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/ListValue$Builder;

    .line 930
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 931
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$1700(Landroidx/datastore/preferences/protobuf/Value;Landroidx/datastore/preferences/protobuf/ListValue$Builder;)V

    .line 932
    return-object p0
.end method

.method public setListValue(Landroidx/datastore/preferences/protobuf/ListValue;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/ListValue;

    .line 917
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 918
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$1600(Landroidx/datastore/preferences/protobuf/Value;Landroidx/datastore/preferences/protobuf/ListValue;)V

    .line 919
    return-object p0
.end method

.method public setNullValue(Landroidx/datastore/preferences/protobuf/NullValue;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/NullValue;

    .line 648
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 649
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$300(Landroidx/datastore/preferences/protobuf/Value;Landroidx/datastore/preferences/protobuf/NullValue;)V

    .line 650
    return-object p0
.end method

.method public setNullValueValue(I)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # I

    .line 622
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 623
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$200(Landroidx/datastore/preferences/protobuf/Value;I)V

    .line 624
    return-object p0
.end method

.method public setNumberValue(D)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # D

    .line 688
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 689
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1, p2}, Landroidx/datastore/preferences/protobuf/Value;->access$500(Landroidx/datastore/preferences/protobuf/Value;D)V

    .line 690
    return-object p0
.end method

.method public setStringValue(Ljava/lang/String;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # Ljava/lang/String;

    .line 742
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 743
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$700(Landroidx/datastore/preferences/protobuf/Value;Ljava/lang/String;)V

    .line 744
    return-object p0
.end method

.method public setStringValueBytes(Landroidx/datastore/preferences/protobuf/ByteString;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/ByteString;

    .line 770
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 771
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$900(Landroidx/datastore/preferences/protobuf/Value;Landroidx/datastore/preferences/protobuf/ByteString;)V

    .line 772
    return-object p0
.end method

.method public setStructValue(Landroidx/datastore/preferences/protobuf/Struct$Builder;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "builderForValue"    # Landroidx/datastore/preferences/protobuf/Struct$Builder;

    .line 858
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 859
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$1300(Landroidx/datastore/preferences/protobuf/Value;Landroidx/datastore/preferences/protobuf/Struct$Builder;)V

    .line 860
    return-object p0
.end method

.method public setStructValue(Landroidx/datastore/preferences/protobuf/Struct;)Landroidx/datastore/preferences/protobuf/Value$Builder;
    .locals 1
    .param p1, "value"    # Landroidx/datastore/preferences/protobuf/Struct;

    .line 845
    invoke-virtual {p0}, Landroidx/datastore/preferences/protobuf/Value$Builder;->copyOnWrite()V

    .line 846
    iget-object v0, p0, Landroidx/datastore/preferences/protobuf/Value$Builder;->instance:Landroidx/datastore/preferences/protobuf/GeneratedMessageLite;

    check-cast v0, Landroidx/datastore/preferences/protobuf/Value;

    invoke-static {v0, p1}, Landroidx/datastore/preferences/protobuf/Value;->access$1200(Landroidx/datastore/preferences/protobuf/Value;Landroidx/datastore/preferences/protobuf/Struct;)V

    .line 847
    return-object p0
.end method
