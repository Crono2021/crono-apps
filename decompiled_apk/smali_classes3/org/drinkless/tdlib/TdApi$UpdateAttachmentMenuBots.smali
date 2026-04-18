.class public Lorg/drinkless/tdlib/TdApi$UpdateAttachmentMenuBots;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateAttachmentMenuBots"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x115df3c2


# instance fields
.field public bots:[Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 21530
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21531
    return-void
.end method

.method public constructor <init>([Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;)V
    .locals 0
    .param p1, "attachmentMenuBotArr"    # [Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;

    .line 21521
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 21522
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateAttachmentMenuBots;->bots:[Lorg/drinkless/tdlib/TdApi$AttachmentMenuBot;

    .line 21523
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 21527
    const v0, 0x115df3c2

    return v0
.end method
