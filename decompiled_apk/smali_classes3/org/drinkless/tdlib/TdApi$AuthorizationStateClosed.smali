.class public Lorg/drinkless/tdlib/TdApi$AuthorizationStateClosed;
.super Lorg/drinkless/tdlib/TdApi$AuthorizationState;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AuthorizationStateClosed"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5af5a360


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 110
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$AuthorizationState;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 115
    const v0, 0x5af5a360

    return v0
.end method
