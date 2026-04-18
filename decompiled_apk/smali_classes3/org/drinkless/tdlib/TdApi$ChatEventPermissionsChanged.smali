.class public Lorg/drinkless/tdlib/TdApi$ChatEventPermissionsChanged;
.super Lorg/drinkless/tdlib/TdApi$ChatEventAction;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatEventPermissionsChanged"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x4e2cc858


# instance fields
.field public newPermissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

.field public oldPermissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 24004
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 24005
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$ChatPermissions;Lorg/drinkless/tdlib/TdApi$ChatPermissions;)V
    .locals 0
    .param p1, "chatPermissions"    # Lorg/drinkless/tdlib/TdApi$ChatPermissions;
    .param p2, "chatPermissions2"    # Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 23994
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$ChatEventAction;-><init>()V

    .line 23995
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatEventPermissionsChanged;->oldPermissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 23996
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatEventPermissionsChanged;->newPermissions:Lorg/drinkless/tdlib/TdApi$ChatPermissions;

    .line 23997
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 24001
    const v0, -0x4e2cc858

    return v0
.end method
