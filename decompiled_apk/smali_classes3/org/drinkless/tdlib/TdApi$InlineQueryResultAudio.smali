.class public Lorg/drinkless/tdlib/TdApi$InlineQueryResultAudio;
.super Lorg/drinkless/tdlib/TdApi$InlineQueryResult;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InlineQueryResultAudio"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3239d2f8


# instance fields
.field public audio:Lorg/drinkless/tdlib/TdApi$Audio;

.field public id:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27124
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 27125
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lorg/drinkless/tdlib/TdApi$Audio;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "audio"    # Lorg/drinkless/tdlib/TdApi$Audio;

    .line 27114
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InlineQueryResult;-><init>()V

    .line 27115
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultAudio;->id:Ljava/lang/String;

    .line 27116
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InlineQueryResultAudio;->audio:Lorg/drinkless/tdlib/TdApi$Audio;

    .line 27117
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27121
    const v0, 0x3239d2f8

    return v0
.end method
