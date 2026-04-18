.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentDocument;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentDocument"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1b5251ff


# instance fields
.field public document:Lorg/drinkless/tdlib/TdApi$Document;

.field public isPinned:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29508
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29509
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Document;Z)V
    .locals 0
    .param p1, "document"    # Lorg/drinkless/tdlib/TdApi$Document;
    .param p2, "z8"    # Z

    .line 29498
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29499
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentDocument;->document:Lorg/drinkless/tdlib/TdApi$Document;

    .line 29500
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentDocument;->isPinned:Z

    .line 29501
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29505
    const v0, -0x1b5251ff

    return v0
.end method
