.class public Lorg/drinkless/tdlib/TdApi$ToggleGiftIsSaved;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ToggleGiftIsSaved"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x29515cf1


# instance fields
.field public isSaved:Z

.field public receivedGiftId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 33228
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33229
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z

    .line 33218
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 33219
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ToggleGiftIsSaved;->receivedGiftId:Ljava/lang/String;

    .line 33220
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$ToggleGiftIsSaved;->isSaved:Z

    .line 33221
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 33225
    const v0, 0x29515cf1

    return v0
.end method
