.class public abstract Lorg/drinkless/tdlib/TdApi$Function;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Function"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lorg/drinkless/tdlib/TdApi$Function$Constructors;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<R:",
        "Lorg/drinkless/tdlib/TdApi$Object;",
        ">",
        "Lorg/drinkless/tdlib/TdApi$Object;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 2104
    .local p0, "this":Lorg/drinkless/tdlib/TdApi$Function;, "Lorg/drinkless/tdlib/TdApi$Function<TR;>;"
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract getConstructor()I
.end method

.method public native toString()Ljava/lang/String;
.end method
