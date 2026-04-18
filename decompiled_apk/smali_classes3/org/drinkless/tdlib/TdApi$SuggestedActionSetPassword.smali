.class public Lorg/drinkless/tdlib/TdApi$SuggestedActionSetPassword;
.super Lorg/drinkless/tdlib/TdApi$SuggestedAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "SuggestedActionSetPassword"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x6f147d98


# instance fields
.field public authorizationDelay:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 20598
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedAction;-><init>()V

    .line 20599
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 20589
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$SuggestedAction;-><init>()V

    .line 20590
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$SuggestedActionSetPassword;->authorizationDelay:I

    .line 20591
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 20595
    const v0, 0x6f147d98

    return v0
.end method
