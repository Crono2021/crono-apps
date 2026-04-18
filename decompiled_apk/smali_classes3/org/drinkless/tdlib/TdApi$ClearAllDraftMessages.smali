.class public Lorg/drinkless/tdlib/TdApi$ClearAllDraftMessages;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ClearAllDraftMessages"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2c38b25


# instance fields
.field public excludeSecretChats:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 10788
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10789
    return-void
.end method

.method public constructor <init>(Z)V
    .locals 0
    .param p1, "z8"    # Z

    .line 10779
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 10780
    iput-boolean p1, p0, Lorg/drinkless/tdlib/TdApi$ClearAllDraftMessages;->excludeSecretChats:Z

    .line 10781
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 10785
    const v0, -0x2c38b25

    return v0
.end method
