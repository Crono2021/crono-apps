.class public Lorg/drinkless/tdlib/TdApi$NotificationGroupTypeSecretChat;
.super Lorg/drinkless/tdlib/TdApi$NotificationGroupType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationGroupTypeSecretChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x52e54e34


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 4303
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$NotificationGroupType;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 4308
    const v0, 0x52e54e34

    return v0
.end method
