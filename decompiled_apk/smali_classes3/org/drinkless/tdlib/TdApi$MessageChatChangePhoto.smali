.class public Lorg/drinkless/tdlib/TdApi$MessageChatChangePhoto;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatChangePhoto"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x307bbab5


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16278
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16279
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 16269
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16270
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatChangePhoto;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 16271
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16275
    const v0, -0x307bbab5

    return v0
.end method
