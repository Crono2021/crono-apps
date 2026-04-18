.class public Lorg/drinkless/tdlib/TdApi$UserStatusOnline;
.super Lorg/drinkless/tdlib/TdApi$UserStatus;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UserStatusOnline"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5b29b88c


# instance fields
.field public expires:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 22538
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserStatus;-><init>()V

    .line 22539
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "i9"    # I

    .line 22529
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$UserStatus;-><init>()V

    .line 22530
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$UserStatusOnline;->expires:I

    .line 22531
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 22535
    const v0, -0x5b29b88c

    return v0
.end method
