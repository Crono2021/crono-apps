.class public Lorg/drinkless/tdlib/TdApi$EditBusinessChatLink;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "EditBusinessChatLink"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$BusinessChatLink;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5f10f626


# instance fields
.field public link:Ljava/lang/String;

.field public linkInfo:Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 25324
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25325
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "inputBusinessChatLink"    # Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;

    .line 25314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 25315
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessChatLink;->link:Ljava/lang/String;

    .line 25316
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$EditBusinessChatLink;->linkInfo:Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;

    .line 25317
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 25321
    const v0, 0x5f10f626

    return v0
.end method
