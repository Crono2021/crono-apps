.class public Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputBusinessChatLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xe2d6df8


# instance fields
.field public text:Lorg/drinkless/tdlib/TdApi$FormattedText;

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27205
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$FormattedText;Ljava/lang/String;)V
    .locals 0
    .param p1, "formattedText"    # Lorg/drinkless/tdlib/TdApi$FormattedText;
    .param p2, "str"    # Ljava/lang/String;

    .line 27194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 27195
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;->text:Lorg/drinkless/tdlib/TdApi$FormattedText;

    .line 27196
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InputBusinessChatLink;->title:Ljava/lang/String;

    .line 27197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27201
    const v0, 0xe2d6df8

    return v0
.end method
