.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultSticker;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultSticker"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6e29a9f5


# instance fields
.field public id:Ljava/lang/String;

.field public sticker:Lorg/drinkless/tdlib/TdApi$Sticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27164
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 27165
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Sticker;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "sticker"    # Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 27154
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 27155
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultSticker;->id:Ljava/lang/String;

    .line 27156
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultSticker;->sticker:Lorg/drinkless/tdlib/TdApi$Sticker;

    .line 27157
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27161
    const v0, -0x6e29a9f5

    return v0
.end method
