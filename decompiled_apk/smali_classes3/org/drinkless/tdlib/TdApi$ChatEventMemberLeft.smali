.class public Lorg/drinkless/tdlib/TdApi$ChatEventMemberLeft;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventMemberLeft"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3887bff1


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1146
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 1151
    const v0, -0x3887bff1

    return v0
.end method
