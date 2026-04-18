.class public Lorg/drinkless/tdlib/TdApi$MessageExpiredVideo;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageExpiredVideo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4840db3d


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 3837
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 3842
    const v0, -0x4840db3d

    return v0
.end method
