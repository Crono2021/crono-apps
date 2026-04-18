.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentGame;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentGame"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1eb446e5


# instance fields
.field public isPinned:Z

.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29528
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29529
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 29518
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29519
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGame;->title:Ljava/lang/String;

    .line 29520
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentGame;->isPinned:Z

    .line 29521
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29525
    const v0, -0x1eb446e5

    return v0
.end method
