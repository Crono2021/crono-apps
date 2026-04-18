.class public Lorg/drinkless/tdlib/TdApi$UpdateChatPhoto;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatPhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x135abdc1


# instance fields
.field public chatId:J

.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34229
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatPhotoInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatPhotoInfo"    # Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;

    .line 34218
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34219
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatPhoto;->chatId:J

    .line 34220
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatPhoto;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhotoInfo;

    .line 34221
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34225
    const v0, -0x135abdc1

    return v0
.end method
