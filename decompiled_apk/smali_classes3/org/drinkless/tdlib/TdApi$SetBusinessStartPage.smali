.class public Lorg/drinkless/tdlib/TdApi$SetBusinessStartPage;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SetBusinessStartPage"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x6112b662


# instance fields
.field public startPage:Lorg/drinkless/tdlib/TdApi$InputBusinessStartPage;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 19572
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19573
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputBusinessStartPage;)V
    .locals 0
    .param p1, "inputBusinessStartPage"    # Lorg/drinkless/tdlib/TdApi$InputBusinessStartPage;

    .line 19563
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 19564
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$SetBusinessStartPage;->startPage:Lorg/drinkless/tdlib/TdApi$InputBusinessStartPage;

    .line 19565
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 19569
    const v0, -0x6112b662

    return v0
.end method
