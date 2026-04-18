.class public Lorg/drinkless/tdlib/TdApi$PushMessageContentText;
.super Lorg/drinkless/tdlib/TdApi$PushMessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PushMessageContentText"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x105ddea9


# instance fields
.field public isPinned:Z

.field public text:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29648
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29649
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 29638
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PushMessageContent;-><init>()V

    .line 29639
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentText;->text:Ljava/lang/String;

    .line 29640
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$PushMessageContentText;->isPinned:Z

    .line 29641
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29645
    const v0, 0x105ddea9

    return v0
.end method
