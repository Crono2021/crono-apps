.class public Lorg/drinkless/tdlib/TdApi$NotificationTypeNewSecretChat;
.super Lorg/drinkless/tdlib/TdApi$NotificationType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "NotificationTypeNewSecretChat"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x4771c6b0


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 4367
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$NotificationType;-><init>()V

    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 4372
    const v0, 0x4771c6b0    # 61894.688f

    return v0
.end method
