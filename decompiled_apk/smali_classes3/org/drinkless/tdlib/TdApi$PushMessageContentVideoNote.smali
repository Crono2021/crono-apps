.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentVideoNote;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentVideoNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x42ec0681


# instance fields
.field public isPinned:Z

.field public videoNote:Lorg/drinkless/tdlib/TdApi$VideoNote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29688
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29689
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$VideoNote;Z)V
    .locals 0
    .param p1, "videoNote"    # Lorg/drinkless/tdlib/TdApi$VideoNote;
    .param p2, "z8"    # Z

    .line 29678
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29679
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentVideoNote;->videoNote:Lorg/drinkless/tdlib/TdApi$VideoNote;

    .line 29680
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentVideoNote;->isPinned:Z

    .line 29681
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29685
    const v0, -0x42ec0681

    return v0
.end method
