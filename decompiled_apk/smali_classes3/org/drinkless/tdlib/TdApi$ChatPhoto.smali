.class public Lorg/drinkless/tdlib/TdApi$ChatPhoto;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x554958b9


# instance fields
.field public addedDate:I

.field public animation:Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;

.field public id:J

.field public minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

.field public sizes:[Lorg/drinkless/tdlib/TdApi$PhotoSize;

.field public smallAnimation:Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;

.field public sticker:Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 51134
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51135
    return-void
.end method

.method public constructor <init>(JILorg/drinkless/tdlib/TdApi$Minithumbnail;[Lorg/drinkless/tdlib/TdApi$PhotoSize;Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "minithumbnail"    # Lorg/drinkless/tdlib/TdApi$Minithumbnail;
    .param p5, "photoSizeArr"    # [Lorg/drinkless/tdlib/TdApi$PhotoSize;
    .param p6, "animatedChatPhoto"    # Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;
    .param p7, "animatedChatPhoto2"    # Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;
    .param p8, "chatPhotoSticker"    # Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;

    .line 51119
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 51120
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ChatPhoto;->id:J

    .line 51121
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ChatPhoto;->addedDate:I

    .line 51122
    iput-object p4, p0, Lorg/drinkless/tdlib/TdApi$ChatPhoto;->minithumbnail:Lorg/drinkless/tdlib/TdApi$Minithumbnail;

    .line 51123
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$ChatPhoto;->sizes:[Lorg/drinkless/tdlib/TdApi$PhotoSize;

    .line 51124
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$ChatPhoto;->animation:Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;

    .line 51125
    iput-object p7, p0, Lorg/drinkless/tdlib/TdApi$ChatPhoto;->smallAnimation:Lorg/drinkless/tdlib/TdApi$AnimatedChatPhoto;

    .line 51126
    iput-object p8, p0, Lorg/drinkless/tdlib/TdApi$ChatPhoto;->sticker:Lorg/drinkless/tdlib/TdApi$ChatPhotoSticker;

    .line 51127
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 51131
    const v0, -0x554958b9

    return v0
.end method
