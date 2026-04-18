.class public Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeDirectMessagesChat;
.super Lorg/drinkless/tdlib/TdApi$LinkPreviewType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "LinkPreviewTypeDirectMessagesChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x22777ade


# instance fields
.field public photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15900
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15901
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPhoto;)V
    .locals 0
    .param p1, "chatPhoto"    # Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 15891
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$LinkPreviewType;-><init>()V

    .line 15892
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$LinkPreviewTypeDirectMessagesChat;->photo:Lorg/drinkless/tdlib/TdApi$ChatPhoto;

    .line 15893
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15897
    const v0, 0x22777ade

    return v0
.end method
