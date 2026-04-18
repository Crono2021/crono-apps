.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentChecklist;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentChecklist"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xca70c4c


# instance fields
.field public isPinned:Z

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29468
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29469
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 29458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29459
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChecklist;->title:Ljava/lang/String;

    .line 29460
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentChecklist;->isPinned:Z

    .line 29461
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29465
    const v0, 0xca70c4c

    return v0
.end method
