.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentContact;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentContact"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xba75ac


# instance fields
.field public isPinned:Z

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29488
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29489
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 29478
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29479
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentContact;->name:Ljava/lang/String;

    .line 29480
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentContact;->isPinned:Z

    .line 29481
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29485
    const v0, -0xba75ac

    return v0
.end method
