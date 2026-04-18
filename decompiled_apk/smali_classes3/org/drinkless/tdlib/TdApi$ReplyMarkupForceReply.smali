.class public Lorg/drinkless/tdlib/TdApi$ReplyMarkupForceReply;
.super Lorg/drinkless/tdlib/TdApi$ReplyMarkup;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReplyMarkupForceReply"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x41a6f99f


# instance fields
.field public inputFieldPlaceholder:Ljava/lang/String;

.field public isPersonal:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 30148
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReplyMarkup;-><init>()V

    .line 30149
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;)V
    .locals 0
    .param p1, "z8"    # Z
    .param p2, "str"    # Ljava/lang/String;

    .line 30138
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ReplyMarkup;-><init>()V

    .line 30139
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupForceReply;->isPersonal:Z

    .line 30140
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ReplyMarkupForceReply;->inputFieldPlaceholder:Ljava/lang/String;

    .line 30141
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 30145
    const v0, 0x41a6f99f

    return v0
.end method
