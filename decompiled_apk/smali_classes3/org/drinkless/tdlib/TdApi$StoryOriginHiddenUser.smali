.class public Lorg/drinkless/tdlib/TdApi$StoryOriginHiddenUser;
.super Lorg/drinkless/tdlib/TdApi$StoryOrigin;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "StoryOriginHiddenUser"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5be29a9


# instance fields
.field public posterName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20490
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryOrigin;-><init>()V

    .line 20491
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 20481
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$StoryOrigin;-><init>()V

    .line 20482
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$StoryOriginHiddenUser;->posterName:Ljava/lang/String;

    .line 20483
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20487
    const v0, -0x5be29a9

    return v0
.end method
